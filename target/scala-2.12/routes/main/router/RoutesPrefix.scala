// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/asus/Desktop/React/dlp-test/conf/routes
// @DATE:Wed Oct 09 15:59:07 GMT+01:00 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
