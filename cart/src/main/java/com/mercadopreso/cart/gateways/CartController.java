@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/items")
    public ResponseEntity<CartDto> addItems(@RequestBody AddItemsRequestDto request) {
        CartDto cartDto = cartService.addItems(request.getItemIdList(), request.getUserId());
        return ResponseEntity.ok(cartDto);
    }
}
```

        ---

        ### 6. Exemplo de chamada (cURL / Postman)
```
POST /cart/items
Content-Type: application/json

{
    "userId": "user-123",
        "itemIdList": ["item-abc", "item-def"]
}