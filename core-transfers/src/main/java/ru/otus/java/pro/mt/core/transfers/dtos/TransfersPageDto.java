package ru.otus.java.pro.mt.core.transfers.dtos;

import java.util.List;

public record TransfersPageDto(
        List<TransferDto> entries,
        int totalPages,
        long totalItems,
        int currentPage,
        int pageSize
) {}