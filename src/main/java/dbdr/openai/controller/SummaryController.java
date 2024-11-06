package dbdr.openai.controller;

import dbdr.openai.dto.response.SummaryResponse;
import dbdr.openai.service.SummaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "요약 API", description = "차트 하루 요약")
@RestController
@RequiredArgsConstructor
@RequestMapping("/${spring.app.version}/summary")
public class SummaryController {

    private final SummaryService summaryService;

    @Operation(summary = "요약한 값을 DB에서 불러온다.", description = "차트 아이디로 요약 데이터를 불러온다.")
    @PostMapping
    public ResponseEntity<SummaryResponse> getSummary(@RequestParam("chartId") Long chartId) {
        return ResponseEntity.ok(summaryService.getSummarization(chartId));
    }
}
