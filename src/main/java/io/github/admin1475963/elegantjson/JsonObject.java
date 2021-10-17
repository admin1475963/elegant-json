/*
 * MIT License
 *
 * Copyright (c) 2021 Muhammad Ilhomov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.admin1475963.elegantjson;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Simple JSON object.
 *
 * @since 0.1.0
 */
public class JsonObject implements ConstructiveJsonObject {

    /**
     * Elements of JSON.
     */
    private final Map<String, JsonRepresentable> elements;

    /**
     * Primary constructor.
     *
     * @param elements Elements
     */
    public JsonObject(final Map<String, JsonRepresentable> elements) {
        this.elements = new LinkedHashMap<>(elements);
    }

    /**
     * Constructor.
     */
    public JsonObject() {
        this(new LinkedHashMap<>());
    }

    @Override
    public final String toJson() {
        return this.elements.entrySet().stream().map(
            entry -> String.format(
                "\"%s\":%s",
                entry.getKey(),
                entry.getValue().toJson()
            )
        ).collect(Collectors.joining(",", "{", "}"));
    }

    @Override
    public final ConstructiveJsonObject add(
        final String key,
        final JsonRepresentable object
    ) {
        final Map<String, JsonRepresentable> map =
            new LinkedHashMap<>(this.elements);
        map.put(key, object);
        return new JsonObject(map);
    }
}
