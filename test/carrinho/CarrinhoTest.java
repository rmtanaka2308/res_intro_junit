package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.DisplayName;
import produto.Produto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {
    private Carrinho cart;
    private Produto caneta;
    private Produto lapis;

	@BeforeEach
	public void inicializa() {
		cart = new Carrinho();
        caneta = new Produto("Caneta", 2.0);
        lapis = new Produto("Lapis", 1.0);
	}

    @Test
    public void testCarrinho() {
        cart.addItem(caneta);
        cart.addItem(lapis);
        
        assertEquals(2, cart.getQtdeItems());
    }

    @Test
    public void testCarrinhoVazio() {
        cart.getQtdeItems();
        assertEquals(0, cart.getQtdeItems());
    }

    @Test
    public void testGetValorTotal() {
        cart.addItem(caneta);
        cart.addItem(lapis);
        
        assertEquals(3, cart.getValorTotal());
    }

    @Test
    public void testEsvazia() {
        cart.addItem(lapis);
        cart.addItem(caneta);
        assertEquals(2, cart.getQtdeItems());
        cart.esvazia();
        assertEquals(0, cart.getQtdeItems());
    }

    @Test
    public void testRemoveItem() throws Exception {
        cart.addItem(lapis);
        cart.addItem(caneta);
        assertEquals(2, cart.getQtdeItems());
        cart.removeItem(lapis);
        assertEquals(1, cart.getQtdeItems());
    }

}
