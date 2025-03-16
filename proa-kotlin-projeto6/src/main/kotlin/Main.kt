package org.example

val user = User()

fun main() {
    iniciarMenu()
}

fun iniciarMenu() {
    while (true) {
        println("Escolha uma das opções abaixo:")
        println(
            """1 - Fazer Registros
              |2 - Mostrar Registros
              |3 - Pesquisar Registros
              |4 - Sair
        """.trimMargin()
        )
        val opcao = lerEntradaNumerica()
        when (opcao) {
            1 -> user.fazerRegistro()
            2 -> user.mostrarRegistros()
            3 -> user.pesquisarUser()
            4 -> break
            else -> println("Opção inválida! Por favor, escolha uma opção válida.")
        }
    }
}

fun lerEntradaNumerica(): Int {
    while (true) {
        try {
            return readln().toInt()
        } catch (e: NumberFormatException) {
            println("Entrada inválida! Por favor, insira um número válido.")
        }
    }
}

class User {
    val nomes = mutableListOf("João Silva", "Maria Oliveira", "Carlos Souza")
    val enderecos = mutableListOf("Rua A, 123", "Av. B, 456", "Rua C, 789")
    val telefones = mutableListOf("(11) 9999-1111", "(22) 8888-2222", "(33) 7777-3333")
    val alturas = mutableListOf(1.75, 1.68, 1.80)
    val salarios = mutableListOf(2500.0, 3200.0, 4000.0)
    val matriculas = mutableListOf("M001", "M002", "M003")
    val nomesSorted = nomes.sorted()
    val enderecosSorted = mutableListOf<String>()
    val telefonesSorted = mutableListOf<String>()
    val alturasSorted = mutableListOf<Double>()
    val salariosSorted = mutableListOf<Double>()
    val matriculasSorted = mutableListOf<String>()



    val mediaAltura: Double
        get(){
            return if(alturas.isNotEmpty()){
                alturas.sum() / alturas.size
            }else{
                0.0
            }
        }

    fun fazerRegistro() {
        var i = 0
        while (i < 2) {
            println("Digite o nome do usuário:")
            val nome = readln()
            nomes.add(nome)
            println("Digite o numero da matricula:")
            val matricula = readln()
            matriculas.add(matricula)
            println("Digite o salario:")
            val salario = readln().toDouble()
            salarios.add(salario)
            nomes.add(nome)
            println("Digite o endereço do usuário:")
            val endereco = readln()
            enderecos.add(endereco)
            println("Digite o telefone do usuário:")
            val telefone = readln()
            telefones.add(telefone)
            println("qual sua altura")
            val altura = readln().toDouble()
            alturas.add(altura)
            i++
        }
        println("media das alturas é ${this.mediaAltura}")
    }



    fun pesquisarUser() {
        var usuarioEncontrado = false
        println("Qual nome ou matricula do usuário que deseja pesquisar?")
        val search = readln()
        for (i in nomes.indices) {
            if (nomes[i] == search || matriculas[i] == search) {
                usuarioEncontrado = true
                val matriculaUser = matriculas[i]
                val enderecoUser = enderecos[i]
                val telefoneUser = telefones[i]
                val alturaUser = alturas[i]
                val salarioUser = salarios[i]
                println("O usuário ${nomes[i]} mora em $enderecoUser possui o telefone $telefoneUser mede $alturaUser e ganha $salarioUser")
            }
        }
        if (!usuarioEncontrado) {
            println("Usuário não encontrado!")
        }
    }

    fun mostrarRegistros() {
        println("escolha a ordem de registros")
        println("0 - ordenar por ordem de entrada")
        println("1 - ordenar por nome")
        println("2 - ordenar por matricula")
        println("3 - maior salario")
        val escolhaRegistro = lerEntradaNumerica()
        when(escolhaRegistro){
            1-> this.ordernarRegistros(this.nomesSorted)
            2-> this.ordernarRegistros(this.matriculasSorted)
            //2-> this.ordernarRegistros(this.salariosSorted)
        }

        if (nomes.isEmpty()) {
            println("Nenhum registro encontrado.")
            return
        }
        val colunaNome = 15
        val colunaMatricula = 10
        val colunaTelefone = 15
        val colunaEndereco = 15
        val colunaAltura = 8
        val colunaSalario = 10

       //head
        println(
            "Nome".padEnd(colunaNome) + " | " +
                    "Matrícula".padEnd(colunaMatricula) + " | " +
                    "Telefone".padEnd(colunaTelefone) + " | " +
                    "Endereço".padEnd(colunaEndereco) + " | " +
                    "Altura".padEnd(colunaAltura) + " | " +
                    "Salário".padEnd(colunaSalario)
        )

        //table body
        for (i in this.nomes.indices) {
            println(
                        this.nomesSorted[i].padEnd(colunaNome) + " | " +
                        this.matriculasSorted[i].padEnd(colunaMatricula) + " | " +
                        this.telefonesSorted[i].padEnd(colunaTelefone) + " | " +
                        this.enderecosSorted[i].toString().padEnd(colunaEndereco) + " | " +
                        this.alturasSorted[i].toString().padEnd(colunaAltura) + " | " +
                        this.salariosSorted[i].toString().padEnd(colunaSalario)
            )
        }
    }

    fun ordernarRegistros(arraySorted: List<Any?>){
        for(e in arraySorted){
            val numeroIndice = nomes.indexOf(e)
             this.enderecosSorted.add(this.enderecos[numeroIndice])
             this.telefonesSorted.add(this.telefones[numeroIndice])
             this.alturasSorted.add(this.alturas[numeroIndice])
             this.salariosSorted.add(this.salarios[numeroIndice])
             this.matriculasSorted.add(this.matriculas[numeroIndice])
        }
    }
}