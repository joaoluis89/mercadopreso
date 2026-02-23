@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public CarDto addItems(List<String> itemIdList, String userId) {
        // Busca carrinho existente ou cria um novo
        Cart cart = cartRepository.findByUserId(userId)
                .orElseGet(() -> Cart.builder()
                        .userId(userId)
                        .itemIdList(new ArrayList<>())
                        .build());

        // Adiciona os itens (sem duplicatas, se quiser)
        cart.getItemIdList().addAll(itemIdList);

        Cart saved = cartRepository.save(cart);

        return CartDto.builder()
                .id(saved.getId())
                .userId(saved.getUserId())
                .itemIdList(saved.getItemIdList())
                .build();
    }
}