import SubsecuenciaMasLarga._

var e1 = subindices(0,3)
var s = Seq (20, 30, 10, 40, 15, 16, 17)
var d = subSecuenciaAsoc(s, Seq())
var d = subSecuenciaAsoc(s, Seq(0,2,4))
var d = subSecuenciaAsoc(s, Seq(1,2,4,6))

var s1 = Seq(20,30,10)
var d = subSecuenciasDe(s1)
var s2 = Seq(20,10,30)
var d = incremental(s2)
var d = subSecuenciasInc(s)
var d = subSecuenciasInc(s1)
var s3 = Seq(20,30,10,40,15,16,17)

var d = subsecuenciaIncrementalMasLarga(s3)
var d = subsecuenciaIncrementalMasLarga(s1)

