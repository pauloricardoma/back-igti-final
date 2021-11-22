package igti.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import igti.desafio.entity.Produto;
import igti.desafio.repository.ProdutoRepository;

@Service
public class ProdutoService {
  
  @Autowired
  private ProdutoRepository produtoRepository;

  public List<Produto> listaProdutos() {
    return produtoRepository.findAll();
  }  

}
