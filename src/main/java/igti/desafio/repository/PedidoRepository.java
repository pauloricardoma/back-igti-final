package igti.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import igti.desafio.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
  
}
