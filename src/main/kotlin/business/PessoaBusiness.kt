package business

import entity.Pessoa

class PessoaBusiness {

    fun maiorIdade(pessoa: Pessoa):Boolean{
        return (pessoa.idade>=18)
    }
}