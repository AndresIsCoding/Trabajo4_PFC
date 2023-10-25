package object SubsecuenciaMasLarga
{
  type Secuencia = Seq[Int]
  type Subsecuencia = Seq[Int]
  def subindices(i:Int, n:Int): Set[Seq[Int]] =
  {
    val initial = (for
  {
    number <- i until n
  } yield Seq(number)) ++ Seq()

    def sequencia(l1:Set[Seq[Int]], l2:Set[Seq[Int]], max_size:Int): Set[Seq[Int]] =
      {
        val nueva_sequencia = for
        {
          numbers_1 <- l1
          numbers_2 <- l2
          if (numbers_1.last < numbers_2.head)
        } yield numbers_1 ++ numbers_2
        if (l1.head.size == max_size) Set(Seq())
        else nueva_sequencia ++ sequencia(nueva_sequencia, l1, max_size)

      }

    initial.toSet ++ sequencia(initial.toSet, initial.toSet, n - i)
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
    val secuencias_iniciales = for {
      valor <- s
    } yield Seq(valor)

    def sequencia(l1: Set[Seq[Int]], l2: Set[Seq[Int]], max_size: Int): Set[Seq[Int]] =
    {
      val nueva_sequencia = for
      {
        numbers_1 <- l1
        numbers_2 <- l2
        if(numbers_1.last < numbers_2.head)
      } yield numbers_1 ++ numbers_2
      if (l1.head.size == max_size) Set(Seq())
      else nueva_sequencia ++ sequencia(nueva_sequencia, l1, max_size)
    }

    secuencias_iniciales.toSet ++ sequencia(secuencias_iniciales.toSet,secuencias_iniciales.toSet, s.size)
}


      def incremental(s: Secuencia): Boolean =
      {
        val pairs = (for{value <- s.init} yield value) zip (for{value <- s.tail} yield value)

        val comparation = for
        {
          pair <- pairs

          if(pair._1 < pair._2)
        }yield 1

        if (comparation.size == pairs.size) true
        else false
      }

  /*
        def subSecuenciasInc(s:Secuencia): Set[Subsecuencia] =
        {

        }

        def subsecuenciaIncrementalMasLarga(s: Secuencia): Subsecuencia =
        {

        }

        def ssimIComenzandoEn(i:Int , s: Secuencia): Subsecuencia =
        {

        }

        def subSecIncMasLargaV2(s: Secuencia): Subsecuencia =
        {

        }
         */
}
