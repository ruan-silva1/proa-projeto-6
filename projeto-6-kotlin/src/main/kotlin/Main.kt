package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val users = User()
    users.pesquisarUser()
    users.mostrarRegistros()
}

class User{
    val nomes = mutableListOf<String>()
    val enderecos = mutableListOf<String>()
    val telefones = mutableListOf<String>()
    val medias = mutableListOf<Double>()

   init{
        repeat(2){
            var i = 1
            var soma = 0.0
            println("digite o nome do usuário")
            val nome = readln()
            nomes.add(nome)
            println("digite o endereço do usuario")
            val endereco = readln()
            enderecos.add(endereco)
            println("digite o telefone do usuario")
            val telefone = readln()
            telefones.add(telefone)
            println("Qual a quantidade de notas atribuitas?")
            val qtdeNotas = readln().toInt()
            while(i<=qtdeNotas){
                println("digite a $i nota")
                var notas = readln().toDouble()
                while(notas < 0.0 || notas > 10.0){
                    println("nota invalida!")
                    println("digite a $i nota")
                     notas = readln().toDouble()
                }
                soma+=notas
                i++
            }
            val media = soma / qtdeNotas
            medias.add(media)

        }
    }

    fun pesquisarUser(){
        var usuarioEncontrado = false
        println("qual nome do usuario que deseja pesquisa")
        val nome = readln()
            for(i in nomes.indices){
                if(nomes[i] == nome){
                    usuarioEncontrado = true
                    val enderecoUser = enderecos[i]
                    val telefoneUser = telefones[i]
                    val media = medias[i]
                    val aprovacao = if(media > 5) "aprovado" else "desaprovado"
                    println("O usuário $nome mora em $enderecoUser e tem o seguinte telefone $telefoneUser sua media foi $media e ele foi $aprovacao")
                }
            }
        if(usuarioEncontrado == false){
            println("usuario nao encontrado!")
        }
    }

    fun mostrarRegistros(){
        var i=0
        val aprovacao = if(medias[i] > 5) "aprovado" else "desaprovado"
        println("usuario | telefone | endereço | media | aprovacao")
        while(i<nomes.size){
            println("${nomes[i]}| ${telefones[i]} | ${enderecos[i]} | ${medias[i]} | ${aprovacao}")
            i++
        }
    }

}

