@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddItemsRequestDto {
    private List<String> itemIdList;
    private String userId;
}