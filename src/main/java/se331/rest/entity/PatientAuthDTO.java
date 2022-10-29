package se331.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author jmm
 * @version 1.0
 * @date 2022/10/29 21:06
 * @email 2867405686@qq.com
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientAuthDTO {
    Long id;
    String name;
    List<String> authorities;
}
