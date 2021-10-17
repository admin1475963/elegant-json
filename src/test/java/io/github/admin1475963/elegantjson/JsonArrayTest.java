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

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link JsonArray}.
 *
 * @since 0.1.0
 */
public final class JsonArrayTest {

    @Test
    public void testEmpty() {
        Assertions.assertEquals(
            "[]",
            new JsonArray().toJson()
        );
    }

    @Test
    public void testWithOneElement() {
        Assertions.assertEquals(
            "[{\"first\":\"element1\"}]",
            new JsonArray()
                .add(
                    new JsonObject()
                    .add("first", new JsonString("element1"))
                )
                .toJson()
        );
    }

    @Test
    public void testWithTwoElements() {
        Assertions.assertEquals(
            "[{\"second\":\"element2\"},{\"third\":\"element3\"}]",
            new JsonArray()
                .add(
                    new JsonObject()
                    .add("second", new JsonString("element2"))
                )
                .add(
                    new JsonObject()
                    .add("third", new JsonString("element3"))
                )
                .toJson()
        );
    }

    @Test
    public void testWithCollectino() {
        final List<JsonRepresentable> list = new LinkedList<>();
        list.add(new JsonObject().add("int", new JsonInt(1)));
        list.add(new JsonObject().add("string", new JsonString("hello")));
        list.add(new JsonObject().add("bool", new JsonBoolean(true)));
        Assertions.assertEquals(
            String.format(
                "[%s,%s,%s]",
                "{\"int\":1}",
                "{\"string\":\"hello\"}",
                "{\"bool\":true}"
            ),
            new JsonArray(list).toJson()
        );
    }
}
