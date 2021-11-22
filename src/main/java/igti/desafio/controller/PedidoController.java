package igti.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import igti.desafio.entity.Pedido;
import igti.desafio.service.PedidoService;

@RestController
public class PedidoController {

  @Autowired 
  private PedidoService pedidoService;

  @PostMapping("/pedidos")
	public ResponseEntity<Pedido> realizaPedido(@RequestBody Pedido pedido) {
    pedidoService.realizaPedido(pedido);
    return new ResponseEntity<Pedido>(pedido, HttpStatus.CREATED); 
	}

  @GetMapping("/pedidos")
	public ResponseEntity<List<Pedido>> obtemPedidos() {
    return ResponseEntity.ok(pedidoService.obtemPedidos());
	}

  @GetMapping("/pedidos/{idPedido}")
  public ResponseEntity<Pedido> obtemPedido(@PathVariable Integer idPedido) {
    return ResponseEntity.ok(pedidoService.obtemPedido(idPedido).get());
  }
  
  @PutMapping("/pedidos/{idPedido}")
  public ResponseEntity<Pedido> updatePedido(@PathVariable Integer idPedido, @RequestBody Pedido pedido) {
    if ( pedidoService.updatePedido(idPedido, pedido)!=null) {
      return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/pedidos/{idPedido}")
  public ResponseEntity<Void> deletePedido(@PathVariable Integer idPedido) {
    pedidoService.deletePedido(idPedido);
    return ResponseEntity.noContent().build();
  }

}
