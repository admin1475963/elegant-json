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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link JsonObject}.
 *
 * @since 0.1.0
 */
public final class JsonObjectTest {

    @Test
    public void testEmpty() {
        Assertions.assertEquals("{}", new JsonObject().toJson());
    }

    @Test
    public void testWithOneElement() {
        Assertions.assertEquals(
            "{\"first\":\"element1\"}",
            new JsonObject()
                .add("first", new JsonString("element1"))
                .toJson()
        );
    }

    @Test
    public void testWithTwoElements() {
        Assertions.assertEquals(
            "{\"second\":\"element2\",\"third\":1}",
            new JsonObject()
                .add("second", new JsonString("element2"))
                .add("third", new JsonInt(1))
                .toJson()
        );
    }

    @Test
    public void testWithMap() {
        Assertions.assertEquals(
            String.format(
                "{%s,%s,%s}",
                "\"string\":\"hello\"",
                "\"int\":2",
                "\"bool\":true"
            ),
            new JsonObject()
                .add("string", new JsonString("hello"))
                .add("int", new JsonInt(2))
                .add("bool", new JsonBoolean(true))
                .toJson()
        );
    }
}
