import SubsecuenciaMasLarga._

//secuencias de prueba
val s1 = Seq() //secuencia de prueba vacia
val s2 = Seq(1) //secuencia de prueba 1 item
val s3 = Seq(1,2) //secuencia de prueba 2+ items
val s4 = Seq(1,5,7) //secuencia de prueba 2+ items incrementales
val s5 = Seq(3,1,6,2) //secuencia de prueba 2+ items no incrementales

//casos de prueba subindices
subindices(0,0)//caso1 i = n
subindices(0,3)//caso2 i < n
subindices(3,0)//caso3 (ilegal) i > n

//casos de prueba subSecuenciaAsoc

//caso1 prueba de la secuencia vacia con indices inferiores y superiores
subSecuenciaAsoc(s1, Seq(-2))
subSecuenciaAsoc(s1, Seq(0))
subSecuenciaAsoc(s1, Seq(2))

//caso2 prueba de la secuencia de un valor con indices inferiores, superiores y intermedios
subSecuenciaAsoc(s2, Seq(-2))
subSecuenciaAsoc(s2, Seq(0))
subSecuenciaAsoc(s2, Seq(2))

//caso3 prueba de la secuencia de 2+ valores con indices inferiores, superiores y intermedios
subSecuenciaAsoc(s3, Seq(-2))
subSecuenciaAsoc(s3, Seq(0))
subSecuenciaAsoc(s3, Seq(0,1))
subSecuenciaAsoc(s3, Seq(1))
subSecuenciaAsoc(s3, Seq(2))

//casos de prueba SubSecuenciaDe

subSecuenciasDe(s1)//caso 1 secuencia de tamaño 0
subSecuenciasDe(s2)//caso 2 secuencia de tamaño 1
subSecuenciasDe(s3)//caso 3 secuencia de tamaño 2+
subSecuenciasDe(s4)//caso 4 secuencia de tamaño 2+ incremental
subSecuenciasDe(s5)//caso 5 secuencia de tamaño 2+ noIncremental

//casos de prueba incremental
incremental(s1)//caso 1 secuencia de tamaño 0
incremental(s4)//caso 2 secuencia de tamaño 2+ incremental
incremental(s5)//caso 3 secuencia de tamaño 2+ noIncremental

//casos de prueba subSecuenciasInc
subSecuenciasInc(s1)//caso 1 secuencia de tamaño 0
subSecuenciasInc(s2)//caso 2 secuencia de tamaño 1
subSecuenciasInc(s4)//caso 3 secuencia de tamaño 2+ incremental
subSecuenciasInc(s5)//caso 4 secuencia de tamaño 2+ noIncremental

//casos de prueba subSecuenciaIncrementalMasLarga
subsecuenciaIncrementalMasLarga(s1)//caso 1 secuencia de tamaño 0
subsecuenciaIncrementalMasLarga(s2)//caso 2 secuencia de tamaño 1
subsecuenciaIncrementalMasLarga(s4)//caso 3 secuencia de tamaño 2+ incremental
subsecuenciaIncrementalMasLarga(s5)//caso 4 secuencia de tamaño 2+ noIncremental

//casos de prueba ssimIComenzandoEn
ssimlComenzandoEn(5,s1)
ssimlComenzandoEn(2,s2)
ssimlComenzandoEn(2,s4)
ssimlComenzandoEn(0,s5)

subSecIncMasLargaV2(s5)
