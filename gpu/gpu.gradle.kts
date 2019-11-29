import ProjectVersions.rlVersion
import org.gradle.internal.component.external.model.ComponentVariant

/*
 * Copyright (c) 2019 Owain van Brakel <https://github.com/Owain94>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

description = "GPU"
version = "0.0.1"

val deps = configurations.create("deps")

dependencies {
    annotationProcessor(Libraries.lombok)
    annotationProcessor(Libraries.pf4j)

    compileOnly("com.openosrs:runelite-api:$rlVersion")
    compileOnly("com.openosrs:runelite-client:$rlVersion")
    compileOnly(Libraries.guice)
    compileOnly(Libraries.javax)
    compileOnly(Libraries.lombok)
    compileOnly(Libraries.rxjava)
    compileOnly(Libraries.pf4j)
    compileOnly(Libraries.jogampJogl)
    compileOnly(Libraries.jogampGluegen)
    compileOnly(Libraries.jogampGluegenLinuxAmd64)
    compileOnly(Libraries.jogampGluegenLinuxI586)
    compileOnly(Libraries.jogampGluegenWindowsAmd64)
    compileOnly(Libraries.jogampGluegenWindowsI586)
    compileOnly(Libraries.jogampJoglLinuxAmd64)
    compileOnly(Libraries.jogampJoglLinuxI586)
    compileOnly(Libraries.jogampJoglWindowsAmd64)
    compileOnly(Libraries.jogampJoglWindowsI586)
}

tasks {
    jar {
        manifest {
            attributes(mapOf(
                    "Plugin-Version" to project.version,
                    "Plugin-Id" to "gpu-plugin",
                    "Plugin-Class" to "net.runelite.client.plugins.gpu.GpuPlugin",
                    "Plugin-Provider" to "OpenOSRS",
                    "Plugin-Dependencies" to ""
            ))
        }

        from(deps.map { if (it.isDirectory) it else zipTree(it) })
    }
}