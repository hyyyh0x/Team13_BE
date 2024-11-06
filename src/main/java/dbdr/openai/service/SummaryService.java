package dbdr.openai.service;

import dbdr.openai.dto.response.SummaryResponse;
import dbdr.openai.entity.Summary;
import dbdr.openai.repository.SummaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SummaryService {

    private final SummaryRepository summaryRepository;

    public SummaryResponse getSummarization(Long chartId) {
        Summary summary = summaryRepository.findByChartId(chartId);
        return new SummaryResponse(summary.getCognitiveManagement(), summary.getBodyManagement(),
            summary.getRecoveryTraining(), summary.getConditionDisease(),
            summary.getNursingManagement());
    }
}
