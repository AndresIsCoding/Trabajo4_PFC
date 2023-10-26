import scala.collection.immutable.{Seq, Set}

package object SubsecuenciaMasLarga
{
  type Secuencia = Seq[Int]
  type Subsecuencia = Seq[Int]

  def subindices(i:Int, n:Int): Set[Seq[Int]] =
  {
    //
    def sequencia(l1: Set[Seq[Int]], l2: Set[Seq[Int]], max_size: Int): Set[Seq[Int]] =
    {
      val nueva_sequencia = for
      {
        numbers_1 <- l1
        numbers_2 <- l2
        if (numbers_1.last < numbers_2.head)
      } yield numbers_1 ++ numbers_2

      if (l1.head.size == max_size) Set(Seq())
      else nueva_sequencia ++ sequencia(nueva_sequencia, l2, max_size)
    }

    if (i < n)
    {
      val initial = (for {number <- i until n} yield Seq(number)) ++ Seq()
      initial.toSet ++ sequencia(initial.toSet, initial.toSet, n - i)
    }else if (i == n) Set(Seq())
    else
      {
        println("i debe ser menor o igual a n")
        Set(Seq())
      }
  }

  def subSecuenciaAsoc(s:Secuencia, inds: Seq[Int]): Subsecuencia =
  {
    val subsecuencia = for
      {
        valor <- s
        indice <- inds
        if(s.indexOf(valor) == indice)
      } yield valor
    subsecuencia
  }

  def subSecuenciasDe(s:Secuencia): Set[Subsecuencia] =
  {
    for
    {
      indice <- subindices(0, s.size)
    }yield subSecuenciaAsoc(s,indice)
  }

  def incremental(s: Secuencia): Boolean =
      {
        if(s.size > 1)
        {
          val pairs = (for {value <- s.init} yield value) zip (for {value <- s.tail} yield value)

        val comparation = for {
          pair <- pairs

          if (pair._1 < pair._2)
        } yield 1

        if (comparation.size == pairs.size) true
        else false
        }else true

      }

  def subSecuenciasInc(s:Secuencia): Set[Subsecuencia] =
      {
        val subsecuencias = subSecuenciasDe(s)

        for
        {
          subsecuencia <- subsecuencias
          if(incremental(subsecuencia))
        }yield subsecuencia

      }

  def subsecuenciaIncrementalMasLarga(s: Secuencia): Subsecuencia =
  {
    val subsecuencias_incrementales = subSecuenciasInc(s)

    def secuencia_mayor(s: Set[Subsecuencia], c: Int): Subsecuencia =
    {
      val subsecuencias_mayores =
      for
      {
        secuencia <- s
        if (secuencia.size > c)
      } yield secuencia

      if(subsecuencias_mayores.size == 0) s.head
      else secuencia_mayor(subsecuencias_mayores, c+1)
    }

    secuencia_mayor(subsecuencias_incrementales, 0)

  }

  def ssimlComenzandoEn(i:Int , s: Secuencia): Subsecuencia =
  {
    def mayores(s: Secuencia):Subsecuencia =
      {
        if (s.size < 1) s
        else
        {
          val lista_mayores = for
          {
            value <- s
            if(value >= s.head)
          }yield value

          Seq(lista_mayores.head) ++ mayores(lista_mayores.tail)
        }
      }

    if (s.size < 1) s
    else
    {
      val lista = for
      {
        value <- s
        if(s.indexOf(value) >= i)
      }yield value

      mayores(lista)

    }
  }

  def subSecIncMasLargaV2(s: Secuencia): Subsecuencia =
  {
    def mas_largo(c:Int, s:Seq[Secuencia]): Subsecuencia =
      {
        val lista = for{value <- s if(value.size >= c)}yield value
        if (lista.isEmpty) s.head
        else mas_largo(c+1, lista)

      }

    if (s.size < 1) s
    else
    {
      val subSecInc = for{value <- 0 until s.size}yield ssimlComenzandoEn(value, s)
      mas_largo(0, subSecInc)
    }
  }
}