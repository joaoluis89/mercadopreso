@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	private String userId;

	@ElementCollection
	private List<String> itemIdList;
}