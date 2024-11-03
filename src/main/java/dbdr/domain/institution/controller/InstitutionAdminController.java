package dbdr.domain.institution.controller;

import dbdr.domain.institution.dto.request.InstitutionRequest;
import dbdr.domain.institution.dto.response.InstitutionResponse;
import dbdr.domain.institution.service.InstitutionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "[관리자] 요양원 (Institution)", description = "요양원 정보 조회, 수정, 삭제, 추가")
@RestController
@RequestMapping("/${spring.app.version}/admin/institution")
@RequiredArgsConstructor
public class InstitutionAdminController {

    private final InstitutionService institutionService;

    @Operation(summary = "전체 요양원 정보 조회")
    @GetMapping
    public ResponseEntity<List<InstitutionResponse>> showAllInstitution() {
        List<InstitutionResponse> institutionResponseList = institutionService.getAllInstitution();
        return ResponseEntity.ok(institutionResponseList);
    }

    @Operation(summary = "요양원 하나의 정보 조회")
    @GetMapping("/{id}")
    public ResponseEntity<InstitutionResponse> showOneInstitution(@PathVariable("id") Long id) {
        InstitutionResponse institutionResponse = institutionService.getInstitutionResponseById(id);
        return ResponseEntity.ok(institutionResponse);
    }

    @Operation(summary = "요양원 추가")
    @PostMapping
    public ResponseEntity<InstitutionResponse> addInstitution(
            @Valid @RequestBody InstitutionRequest institutionRequest) {
        InstitutionResponse institutionResponse = institutionService.addInstitution(
                institutionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(institutionResponse);
    }

    @Operation(summary = "요양원 정보 수정")
    @PutMapping("/{id}")
    public ResponseEntity<InstitutionResponse> updateInstitution(@PathVariable("id") Long id,
                                                                 @Valid @RequestBody InstitutionRequest institutionRequest) {
        InstitutionResponse institutionResponse = institutionService.updateInstitution(id,
                institutionRequest);
        return ResponseEntity.ok(institutionResponse);
    }

    @Operation(summary = "요양원 삭제")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstitution(@PathVariable("id") Long id) {
        institutionService.deleteInstitutionById(id);
        return ResponseEntity.noContent().build();
    }
}