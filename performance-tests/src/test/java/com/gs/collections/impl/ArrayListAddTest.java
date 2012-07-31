/*
 * Copyright 2012 Goldman Sachs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gs.collections.impl;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

public class ArrayListAddTest
{
    @Test
    public void runArrayListAdd()
    {
        this.runIntegerArrayListAdd("integer");
        this.runLongArrayListAdd("long");
        this.runIntegerArrayListAdd("integer");
        this.runStringArrayListAdd("string");
        this.runIntegerArrayListAdd("integer");
        this.runLongArrayListAdd("long");
        this.runIntegerArrayListAdd("integer");
        this.runStringArrayListAdd("string");
    }

    private void runIntegerArrayListAdd(String type)
    {
        System.currentTimeMillis();
        Random r = new Random(123412123);
        Integer[] ints = new Integer[1000000];
        for (int i = 0; i < ints.length; i++)
        {
            ints[i] = r.nextInt();
        }
        this.runArrayListAdds(type, ints);
    }

    public void runArrayListAdd(Object[] objects, int length, int runs)
    {
        for (int i = 0; i < runs; i++)
        {
            ArrayList list = new ArrayList();
            for (int j = 0; j < length; j++)
            {
                list.add(objects[j]);
            }
        }
    }

    private void runLongArrayListAdd(String type)
    {
        System.currentTimeMillis();
        Random r = new Random(123412123);
        Long[] longs = new Long[1000000];
        for (int i = 0; i < longs.length; i++)
        {
            longs[i] = r.nextLong();
        }
        this.runArrayListAdds(type, longs);
    }

    private void runArrayListAdds(String type, Object[] objects)
    {
        for (int i = 0; i < 100; i++)
        {
            this.runArrayListAdd(objects, 1000, 1000);
        }
        for (int i = 0; i < 100; i++)
        {
            this.runArrayListAdd(objects, 1000000, 10);
        }
        long now = System.currentTimeMillis();
        for (int i = 0; i < 100; i++)
        {
            this.runArrayListAdd(objects, 1000000, 10);
        }
        long time = System.currentTimeMillis() - now;
        System.out.println("ArrayList, list size 1,000,000, " + type + " adds/msec: " + 1000000000 / time);
    }

    private void runStringArrayListAdd(String type)
    {
        System.currentTimeMillis();
        Random r = new Random(123412123);
        String[] strings = new String[1000000];
        for (int i = 0; i < strings.length; i++)
        {
            strings[i] = String.valueOf(r.nextLong());
        }
        this.runArrayListAdds(type, strings);
    }

}
