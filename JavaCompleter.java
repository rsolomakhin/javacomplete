// Copyright 2015 Rouslan Solomakhin
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;

public class JavaCompleter {
    public static void main(String[] args) throws IOException {
        new JavaCompleter().run();
    }

    private void run() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner s = null;
        for (String filename = in.readLine(); filename != null; filename = in.readLine()) {
            s = new Scanner(new File(filename));
            s.useDelimiter("\\Z");
            ASTParser parser = ASTParser.newParser(AST.JLS3);
            parser.setSource(s.next().toCharArray());
            parser.setKind(ASTParser.K_COMPILATION_UNIT);
            final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        }
    }
}
