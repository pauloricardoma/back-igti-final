package igti.desafio.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import igti.desafio.entity.Pedido;
import igti.desafio.repository.PedidoRepository;

@Service
public class PedidoService {
  
  @Autowired
  private PedidoRepository pedidoRepository;

  public Pedido realizaPedido(Pedido pedido) {
    pedido.setDataHora(LocalDateTime.now());
    pedido.setSituacao(Pedido.SITUACAO_AGUARDANDO);
    return pedidoRepository.save(pedido);
  }

  public List<Pedido>obtemPedidos() {
    return pedidoRepository.findAll();
  }  

  public Optional<Pedido> obtemPedido(Integer idPedido) {
    return pedidoRepository.findById(idPedido);
  }

  public Pedido updatePedido(Integer idPedido, Pedido newPedido) {
    return pedidoRepository.findById(idPedido).map(c -> {
      c.setSituacao(newPedido.getSituacao());
      Pedido atualizado = pedidoRepository.save(c);
      return atualizado;
    }).orElse(null);
  }

  public void deletePedido(Integer idPedido) {
      if (pedidoRepository.findById(idPedido)!=null)
          pedidoRepository.deleteById(idPedido);
  }

}
