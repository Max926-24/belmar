package de.ait.belmar.service;

import de.ait.belmar.domain.Product;
import de.ait.belmar.domain.ProductionReceipt;
import de.ait.belmar.domain.ProductionReceiptItem;
import de.ait.belmar.domain.User;
import de.ait.belmar.domain.enums.DocumentStatus;
import de.ait.belmar.dto.mapping.ProductionReceiptMapper;
import de.ait.belmar.dto.receipt.ProductionReceiptDto;
import de.ait.belmar.dto.receipt.ProductionReceiptSaveDto;
import de.ait.belmar.dto.receipt.ReceiptItemSaveDto;
import de.ait.belmar.exceptions.EntityNotFoundException;
import de.ait.belmar.repository.ProductRepository;
import de.ait.belmar.repository.ProductionReceiptRepository;
import de.ait.belmar.repository.UserRepository;
import de.ait.belmar.service.interfaces.ProductionReceiptService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductionReceiptServiceImpl implements ProductionReceiptService {

    private final ProductionReceiptRepository receiptRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ProductionReceiptMapper mapper;

    public ProductionReceiptServiceImpl(ProductionReceiptRepository receiptRepository
            , ProductRepository productRepository,
                                        UserRepository userRepository,
                                        ProductionReceiptMapper mapper) {
        this.receiptRepository = receiptRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }


    @Override
    @Transactional
    public ProductionReceiptDto create(ProductionReceiptSaveDto saveDto) {

        User currentUser = getCurrentUser();

        ProductionReceipt receipt = new ProductionReceipt();
        receipt.setDocDate(saveDto.getDocDate());
        receipt.setStatus(DocumentStatus.DRAFT);
        receipt.setCreatedBy(currentUser);

        for (ReceiptItemSaveDto itemDto : saveDto.getItems()) {
            Product product = productRepository.findById(itemDto.getProductId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            String.format("Product with id %s not found", itemDto.getProductId())
                    ));

            ProductionReceiptItem item = new ProductionReceiptItem();
            item.setProduct(product);
            item.setQuantity(itemDto.getQuantity());

            receipt.addItem(item);
        }

        ProductionReceipt saved = receiptRepository.save(receipt);
        return mapper.mapEntityToDto(saved);


    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductionReceiptDto> findAll() {
        return receiptRepository.findAll()
                .stream()
                .map(mapper::mapEntityToDto)
                .toList();

    }

    private User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("User %s not found", username)
                ));

    }
}
