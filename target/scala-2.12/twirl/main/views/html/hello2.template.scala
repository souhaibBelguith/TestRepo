
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._
/*1.2*/import entities._

object hello2 extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[Image],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(list: List[Image]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.21*/("""

"""),format.raw/*4.1*/("""<ul>
	"""),_display_(/*5.3*/for(index <- 0 until list.size) yield /*5.34*/ {_display_(Seq[Any](format.raw/*5.36*/("""
	"""),format.raw/*6.2*/("""<li><img src="""),_display_(/*6.16*/list/*6.20*/.get(index).getDownload_url()),format.raw/*6.49*/(""" """),format.raw/*6.50*/("""width="200"
		height="100"></img></li> """)))}),format.raw/*7.29*/("""

"""),format.raw/*9.1*/("""</ul>"""))
      }
    }
  }

  def render(list:List[Image]): play.twirl.api.HtmlFormat.Appendable = apply(list)

  def f:((List[Image]) => play.twirl.api.HtmlFormat.Appendable) = (list) => apply(list)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Oct 08 18:33:09 GMT+01:00 2019
                  SOURCE: C:/Users/asus/Desktop/React/dlp-test/app/views/hello2.scala.html
                  HASH: 8bc49944efaf97d6f8507124e47d15aa3e370763
                  MATRIX: 651->1|979->22|1093->41|1123->45|1156->53|1202->84|1241->86|1270->89|1310->103|1322->107|1371->136|1399->137|1470->178|1500->182
                  LINES: 24->1|29->2|34->2|36->4|37->5|37->5|37->5|38->6|38->6|38->6|38->6|38->6|39->7|41->9
                  -- GENERATED --
              */
          