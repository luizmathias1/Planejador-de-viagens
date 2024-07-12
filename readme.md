Este é um projeto backend desenvolvido em java com o framework swing 

COMO USAR

localize o arquivo PlannerApplication que está em planner/main/java/PlannerApplication.jar

por ser um projeto de backend que ainda não tenho um front precisamos usar alguma plataforma para utilizalo como por exemplo o insomnia

precisamos criar um metodo POST para criar viagens nesse metodo colocamos a url localhost:8080/trips e fazemos um JSON nele podemos colocar as informações de exemplo 

{
	"destination": "Floriánopolis, SC",
	"starts_at": "2024-06-25T21:51:54.734Z",
	"ends_at": "2024-06-25T21:51:54.734Z",
	"emails_to_invite":[
		"luizmatiasrivabem@gmail.com",
		"leonards@gmail.com"
	],
	"owner_name": "Luiz Mathias",
	"owner_email": "luizmathiasrivabem@gmail.com"
}

E ele retornara o ID da nossa trip onde usaremos ele para acessar outros metodos, como

Recuperar viagem que usaremos o link localhost:8080/trips/(id da nossa trip) e se seguirmos o exemplo acima teremos como resposta
{
	"id": "f1abadbf-0598-456a-a19e-1cff7afe6589",
	"destination": "Floriánopolis, SC",
	"startsAt": "2024-06-25T21:51:54.734",
	"endsAt": "2024-06-25T21:51:54.734",
	"isConfirmed": false,
	"ownerName": "Luiz Mathias",
	"ownerEmail": "luizmathiasrivabem@gmail.com"
}

Podemos também mudar dados da viagem com um metodo PUT onde nossa url será localhost:8080/trips/(id da nossa trip) e podemos alterar local e datas de incio e termino segue o exemplo
{
	"destination": "Gramado, RS",
	"starts_at": "2024-06-25T21:51:54.734Z",
	"ends_at": "2024-06-25T21:51:54.734Z"
}

e se buscarmos novamento nossa viagem teremos como resultado:
{
	"id": "f1abadbf-0598-456a-a19e-1cff7afe6589",
	"destination": "Gramado, RS",
	"startsAt": "2024-06-25T21:51:54.734",
	"endsAt": "2024-06-25T21:51:54.734",
	"isConfirmed": false,
	"ownerName": "Luiz Mathias",
	"ownerEmail": "luizmathiasrivabem@gmail.com"
}

temos também a opção de confirmar a viagem que fica com a url localhost:8080/trips/(id da viagem)/confirm que fazendo a mudança nosso campo isConfirmed fica como true:
{
	"id": "f1abadbf-0598-456a-a19e-1cff7afe6589",
	"destination": "Gramado, RS",
	"startsAt": "2024-06-25T21:51:54.734",
	"endsAt": "2024-06-25T21:51:54.734",
	"isConfirmed": true,
	"ownerName": "Luiz Mathias",
	"ownerEmail": "luizmathiasrivabem@gmail.com"
}

temos o campo para criar participantes da viagem que segue o link localhost:8080/trips/(id da viagem)/invite onde preenchemos o email do nosso candidato:
{
	"email": "convidado1@gmail.com"
}

teremos o retorno do id deste convite e com ele o convidado pode confirmar sua participação no campo Confirmar participantes que segue a url localhost:8080/participants/(id do convidado)/confirm:
{
	"id": "92209505-58bc-4f90-ae2a-08c62fdac6ae",
	"isConfirmed": true,
	"name": "Convidado1",
	"email": "convidado1@gmail.com",
	"trip": {
		"id": "f1abadbf-0598-456a-a19e-1cff7afe6589",
		"destination": "Gramado, RS",
		"startsAt": "2024-06-25T21:51:54.734",
		"endsAt": "2024-06-25T21:51:54.734",
		"isConfirmed": true,
		"ownerName": "Luiz Mathias",
		"ownerEmail": "luizmathiasrivabem@gmail.com"
	}
}

e também temos o campo de recuperar os participantes da viagem que é na url localhost:8080/(id viagem)/participants:
[
	{
		"id": "0a5483a2-225a-4d5e-a15f-1bdd88f51678",
		"name": "",
		"email": "luizmatiasrivabem@gmail.com",
		"isConfirmed": false
	},
	{
		"id": "92209505-58bc-4f90-ae2a-08c62fdac6ae",
		"name": "Convidado1",
		"email": "convidado1@gmail.com",
		"isConfirmed": true
	}
]

E como uma boa viagem não podem faltar as atividades que podemos criar em localhost:8080/trips/(id viagem)/activities:
{
	"title": "Visita ao Melhor restaurante da região",
	"occurs_at": "2024-06-23T21:51:54.734Z"
}

e podemos trazer devolta essas informações em recuperar atividades em localhost:8080/trips/(id da atividade)/activities:
[
	{
		"id": "ede86f3d-3bfc-4cc0-a988-641c13dea56f",
		"title": "Visita ao Melhor restaurante da região",
		"occurs_at": "2024-06-23T21:51:54.734"
	}
]

e como ultimas funções podemos criar um link e recuperar todos os links da viagem criamos em localhost:8080/trips/(id viagem)/links(estou usando links provisórios):
{
	"title": "Link do facebook",
	"url": "https://facebook.com"
}

e recuperamos ele no url localhost:8080/trips/(id viagem)/links e teremos nossa lista com todos os links
