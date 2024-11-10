package dbdr.domain.guardian.dto.response;

public record GuardianResponse(
    Long id,
    String phone,
    String name,
    boolean isActive) {
}
