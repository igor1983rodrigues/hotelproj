# hotelproj

# Descrição
Projeto desenvolvido nas camadas de controle, modelo e serviço, com o intuito de realizar checkin em hotel

# Exemplos
HOSPEDES
* (GET) http://localhost:8080/hotelproj/api/hospede/

Cadastrar Hospede
* (POST) http://localhost:8080/hotelproj/api/hospede/
  passando um JSON, como: {"nomeHospede":"Igor Rodrigues","documentoHospede":"12345678912","telefoneHospede":"047999206579"}

Alterando Cadastro:
* (PUT) http://localhost:8080/hotelproj/api/hospede/<id do hospede>
  Passando o json com as mesmas chaves do cadastro
  
Excluindo Cadastro
* (DELETE) http://localhost:8080/hotelproj/api/hospede/<id do hospede>

CHECKIN
Buscas em aberto:
* (GET) http://localhost:8080/hotelproj/api/checkin/emaberto
* (GET) http://localhost:8080/hotelproj/api/checkin/emaberto/nome/<nome do hospede>
* (GET) http://localhost:8080/hotelproj/api/checkin/emaberto/documento/<número do documento>
* (GET) http://localhost:8080/hotelproj/api/checkin/emaberto/telefone/<telefone do hospede>

Fazer Checkin:
* (POST) http://localhost:8080/hotelproj/api/checkin/<id do hospede>
* (POST) http://localhost:8080/hotelproj/api/checkin/documento/<número de documento do hospede>
  Em todos os casos, o json informado será {"adicionalVeiculoCheckin":true/false}
  
Registrar saída do hotel
* (PUT) http://localhost:8080/hotelproj/api/checkin/<id do hospede>/encerrar
* (PUT) http://localhost:8080/hotelproj/api/checkin/encerrar/<Número do documento do hospede>

Algumas coisas fiquei devendo, pois o Eclipse ainda dava muitos erros, quais consumiu a maior parte do tempo para corrigir.
Desde já, continuarei a fazer a manutenção da aplicação.


# Ficha técnica
  Servidor Apache Tomcat v9
  -
  IDE "Eclipse Java EE IDE for Web Developers", versão Oxygen.3a Release (4.7.3a)
  -
  Banco de Dados PostgreSQL v10
  -
  Frameworks:
  * Hibernate 5.3.7
  * Jersey 2.27
