package dbdr.openai.dto.response;

import java.time.LocalDateTime;

public record SummaryApiFinalResponse(SummaryResponse summaryResponse, TagResponse tagResponse,
                                      LocalDateTime updatedAt, String institutionName) {

}
