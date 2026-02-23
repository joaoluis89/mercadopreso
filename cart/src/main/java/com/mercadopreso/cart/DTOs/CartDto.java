@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDto {
    private String id;
    private String userId;
    private List<String> itemIdList;
}