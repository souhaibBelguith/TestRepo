
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

object images extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[Image],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(list: List[Image]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.21*/("""


"""),format.raw/*5.1*/("""<ul>
<li><input type="submit" onclick="location.href='/changeTest';" value="View one image" /></li>
	"""),_display_(/*7.3*/for(index <- 0 until list.size) yield /*7.34*/ {_display_(Seq[Any](format.raw/*7.36*/("""
	"""),format.raw/*8.2*/("""<li><img src="""),_display_(/*8.16*/list/*8.20*/.get(index).getDownload_url()),format.raw/*8.49*/(""" """),format.raw/*8.50*/("""width="200"
		height="100"></img></li> """)))}),format.raw/*9.29*/("""

"""),format.raw/*11.1*/("""</ul>"""))
      }
    }
  }

  def render(list:List[Image]): play.twirl.api.HtmlFormat.Appendable = apply(list)

  def f:((List[Image]) => play.twirl.api.HtmlFormat.Appendable) = (list) => apply(list)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Thu Oct 10 13:58:20 GMT+01:00 2019
                  SOURCE: C:/Users/asus/Desktop/React/dlp-test/app/views/images.scala.html
                  HASH: da802b2a08d8ac65aa5b4f7484be5004a63726e3
                  MATRIX: 651->1|979->22|1093->41|1125->47|1254->151|1300->182|1339->184|1368->187|1408->201|1420->205|1469->234|1497->235|1568->276|1599->280
                  LINES: 24->1|29->2|34->2|37->5|39->7|39->7|39->7|40->8|40->8|40->8|40->8|40->8|41->9|43->11
                  -- GENERATED --
              */
          