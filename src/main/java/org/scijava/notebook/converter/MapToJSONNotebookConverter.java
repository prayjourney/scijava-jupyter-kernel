/*-
 * #%L
 * SciJava polyglot kernel for Jupyter.
 * %%
 * Copyright (C) 2017 Hadrien Mary
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

package org.scijava.notebook.converter;

import java.util.Map;

import org.scijava.convert.Converter;
import org.scijava.notebook.converter.output.JSONNotebookOutput;
import org.scijava.plugin.Plugin;

@Plugin(type = Converter.class)
public class MapToJSONNotebookConverter<K, V>
        extends NotebookOutputConverter<Map<K, V>, JSONNotebookOutput> {

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Class<Map<K, V>> getInputType() {
        return (Class) Map.class;
    }

    @Override
    public Class<JSONNotebookOutput> getOutputType() {
        return JSONNotebookOutput.class;
    }

    @Override
    public JSONNotebookOutput convert(Object object) {
        return new JSONNotebookOutput(object.toString());
    }

}
