    package com.example.projeto.models;

    import jakarta.persistence.*;

    @Entity
    @Table(name = "funcionario")
    public class Funcionario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_func")
        private Long id;

        @Column(name = "nome_func")
        private String nome;

        @Column(name = "linguagem_func")
        private String linguagem;

        @ManyToOne
        @JoinColumn(name = "usu_id")
        private Usuario usuario;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getLinguagem() {
            return linguagem;
        }

        public void setLinguagem(String linguagem) {
            this.linguagem = linguagem;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

    }