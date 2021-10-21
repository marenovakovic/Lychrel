import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LychrelTest {

    @Test
    fun facts() {
        convergesAtIteration(BigInteger.valueOf(1), BigInteger.valueOf(0))
        convergesAtIteration(BigInteger.valueOf(2), BigInteger.valueOf(0))
        convergesAtIteration(BigInteger.valueOf(10), BigInteger.valueOf(1))
        convergesAtIteration(BigInteger.valueOf(11), BigInteger.valueOf(0))
        convergesAtIteration(BigInteger.valueOf(19), BigInteger.valueOf(2))
        convergesAtIteration(BigInteger.valueOf(78), BigInteger.valueOf(4))
        convergesAtIteration(BigInteger.valueOf(89), BigInteger.valueOf(24))

        doesNotConverge(BigInteger.valueOf(196))
    }

    private fun convergesAtIteration(n: BigInteger, iteration: BigInteger) {
        assertEquals(iteration, Lychrel.convergesAtIteration(n, limit))
    }

    private fun doesNotConverge(n: BigInteger) {
        convergesAtIteration(n, limit)
    }

    @Test
    fun palindromes() {
        isPalindrome(BigInteger.valueOf(1))
        isPalindrome(BigInteger.valueOf(11))
        isPalindrome(BigInteger.valueOf(121))
        isPalindrome(BigInteger.valueOf(12321))
    }

    @Test
    fun notPalindromes() {
        isNotPalindrome(BigInteger.valueOf(10))
        isNotPalindrome(BigInteger.valueOf(12))
        isNotPalindrome(BigInteger.valueOf(12331))
        isNotPalindrome(BigInteger.valueOf(124331))
    }

    private fun isPalindrome(n: BigInteger) {
        assertTrue(Lychrel.isPalindrome(n))
    }

    private fun isNotPalindrome(n: BigInteger) {
        assertFalse(Lychrel.isPalindrome(n))
    }

    @Test
    fun reversals() {
        reversed(BigInteger.valueOf(321), BigInteger.valueOf(123))
        reversed(BigInteger.valueOf(654321), BigInteger.valueOf(123456))
        reversed(BigInteger.valueOf(654321), BigInteger.valueOf(123456))
    }

    private fun reversed(n: BigInteger, reversed: BigInteger) {
        assertEquals(reversed, Lychrel.reverse(n))
    }

    companion object {
        private val limit = BigInteger.valueOf(1000)
    }
}