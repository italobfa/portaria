package control

class Console private constructor() {

    companion object {
        fun readInt(msg: String): Int {

            var retorno: Int? = null

            do {
                print(msg)
                val info = readLine()

                if (info != null && info != "") {
                    retorno = info.toIntOrNull()

                    if (retorno == null || retorno <= 0) {
                        println("Valor invalido")
                    }
                } else {
                    //Retornando invalido caso o campo esteja vazio.
                    println("Valor invalido")
                }
            } while (retorno == null || retorno <= 0)
            return retorno
        }

        fun readString(msg: String): String {

            var retorno: String? = null

            do {
                print(msg)
                val info = readLine()

                if (info != null && info != "") {
                    retorno = info.lowercase()
                }
            } while (retorno == null)
            return retorno
        }
    }

}