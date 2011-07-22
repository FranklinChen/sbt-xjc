import sbt._
import Keys._

object build extends Build {
  val sbtXjc = Project(
    id = "sbt-xjc",
    base = file("."),
    settings = Defaults.defaultSettings ++ ScriptedPlugin.scriptedSettings ++ Seq(
      organization := "com.github.retronym",
      version := "0.2-SNAPSHOT",
      sbtPlugin := true,
      publishTo <<= (version) { (v: String) =>
        val repoSuffix = if (v.contains("-SNAPSHOT")) "snapshots" else "releases"
        val resolver = Resolver.file("gh-pages",  new File("/Users/jason/code/retronym.github.com/repo", repoSuffix))
        Some(resolver)
      }
    )
  )
}