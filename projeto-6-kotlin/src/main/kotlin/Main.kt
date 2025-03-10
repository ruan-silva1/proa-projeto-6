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

   init{
        var i = 0
        while(i<2){
            println("digite o nome do usuário")
            val nome = readln()
            nomes.add(nome)
            println("digite o endereço do usuario")
            val endereco = readln()
            enderecos.add(endereco)
            println("digite o telefone do usuario")
            val telefone = readln()
            telefones.add(telefone)
            i++
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
                    println("O usuário $nome mora em $enderecoUser e tem o seguinte telefone $telefoneUser")
                }
            }
        if(usuarioEncontrado == false){
            println("usuario nao encontrado!")
        }
    }

    fun mostrarRegistros(){
        var i=0
        while(i<nomes.size){
            println("usuario | telefone | endereço")
            println("${nomes[i]}| ${telefones[i]} | ${enderecos[i]}")
            i++
        }
    }

}