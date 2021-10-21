import java.math.BigInteger

object Lychrel {
    fun convergesAtIteration(n: BigInteger, limit: BigInteger): BigInteger =
        converge(n, BigInteger.valueOf(0), limit)

    private tailrec fun converge(n: BigInteger, iteration: BigInteger, limit: BigInteger): BigInteger =
        if (!isPalindrome(n) && iteration < limit)
            converge(n + reverse(n), iteration + BigInteger.valueOf(1), limit)
        else iteration

    fun isPalindrome(n: BigInteger): Boolean {
        val number = n.toString()
        val reversed = number.reversed()
        return number == reversed
    }

    fun reverse(n: BigInteger): BigInteger =
        n.toString().reversed().toBigInteger()
}