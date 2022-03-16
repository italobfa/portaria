package control

import business.ConviteBusiness
import business.PessoaBusiness
import entity.Convite
import entity.Pessoa

class Portaria {

    private val conviteBusiness = ConviteBusiness()
    private val pessoaBusiness = PessoaBusiness()

    init {
        println("Portaria iniciada")
        println(controle())
    }

    private fun controle(): String {
        val idade = Console.readInt("Qual sua idade?")
        val pessoa = Pessoa(idade)
        if(!pessoaBusiness.maiorIdade(pessoa)){
            return ("Negado. Menores de idade não são permitidos.")
        }
        /*if (idade < 18) {
            return ("Negado. Menores de idade não são permitidos.")
        }*/

        val tipoConvite = Console.readString("Qual seu tipo de convite?")
        if (!conviteBusiness.tipoValido(tipoConvite)){
            return "Negado. Convite inválido."
        }

        val codigo = Console.readString("Qual é o código do convite?")
        val convite = Convite(tipoConvite, codigo)
        if (!conviteBusiness.codigoValido(convite)){
            return "Negado. Convite inválido."
        }


        return "Bem-vindo!"
    }

    fun portaria() {
        /*print("Qual sua idade? ")
        val idade = readLine()
        if (idade != null && idade != "") {
            if (idade.toInt() < 18) {
                println("Negado. Menores de idade não são permitidos.")
                return
            }
        }*/
        print("Qual é o tipo de convite? ")
        var tipoConvite = readLine()
        if (tipoConvite != null && tipoConvite != "") {
            tipoConvite = tipoConvite.lowercase()
            // Validação do tipo de convite
            if (tipoConvite != "comum" && tipoConvite != "premium" && tipoConvite != "luxo") {
                println("Negado. entity.Convite inválido.")
                return
            }
            print("Qual o código do convite? ")
            var codigo = readLine()
            if (codigo != null && codigo != "") {
                codigo = codigo.lowercase()
                if (tipoConvite == "comum" && codigo.startsWith("xt")) {
                    println("Bem-vindo :)")
                } else if ((tipoConvite == "premium" || tipoConvite == "luxo") && codigo.startsWith("xl")
                ) {
                    println("Bem-vindo :)")
                } else {
                    println("Negado. entity.Convite inválido")
                }
            }
        }
    }
}