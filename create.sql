create sequence pedido_seq start 1 increment 1;
create table item_pedido (id_pedido int4 not null, id_produto int4, quantidade int4);
create table pedido (id_pedido int4 not null, data_hora timestamp, situacao varchar(255), primary key (id_pedido));
create table produto (id_produto int4 not null, categoria varchar(255), descricao varchar(255), preco float8, primary key (id_produto));
alter table item_pedido add constraint FKnqncqw8pnv54kv0dct6mo2iei foreign key (id_produto) references produto;
alter table item_pedido add constraint FKnjghutiejefh2auj9bnpf9sp7 foreign key (id_pedido) references pedido;
