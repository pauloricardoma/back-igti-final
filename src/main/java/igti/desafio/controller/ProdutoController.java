package igti.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import igti.desafio.entity.Produto;
import igti.desafio.service.ProdutoService;

@RestController
@Transactional
public class ProdutoController {

  @Autowired
  private ProdutoService produtoService;

	@GetMapping("/cardapio")
	public ResponseEntity<List<Produto>> listaProdutos() {
    List<Produto> listar = produtoService.listaProdutos();
    return ResponseEntity.ok(listar);
	}

}
