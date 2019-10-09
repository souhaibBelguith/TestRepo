
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

object hello extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(url : String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.16*/("""

"""),format.raw/*3.1*/("""<ul>
	<li><input type="submit"
		onclick="location.href='/changeTest';" value="View a list of image" /></li>

	<li><img src="""),_display_(/*7.16*/url),format.raw/*7.19*/(""" """),format.raw/*7.20*/("""/></li>
</ul>"""))
      }
    }
  }

  def render(url:String): play.twirl.api.HtmlFormat.Appendable = apply(url)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (url) => apply(url)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Oct 09 16:09:23 GMT+01:00 2019
                  SOURCE: C:/Users/asus/Desktop/React/dlp-test/app/views/hello.scala.html
                  HASH: 7bf26d5b2b17c121c0bd4c440dd64ac5ddacc005
                  MATRIX: 948->1|1057->15|1087->19|1242->148|1265->151|1293->152
                  LINES: 28->1|33->1|35->3|39->7|39->7|39->7
                  -- GENERATED --
              */
          