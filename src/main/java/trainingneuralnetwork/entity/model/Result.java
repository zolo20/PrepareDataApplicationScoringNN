package trainingneuralnetwork.entity.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class Result {
    private Boolean answer;
    private Double score;
}
