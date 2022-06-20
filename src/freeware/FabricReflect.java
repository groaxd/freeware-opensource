package freeware;

import java.lang.reflect.Field;
import java.util.Iterator;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

public class FabricReflect {
   public static Field getField(final Class cls, String obfName, String deobfName) {
      if (cls == null)
         return null;

      Field field = null;
      for (Class cls1 = cls; cls1 != null; cls1 = cls1.getSuperclass()) {
         try {
            field = cls1.getDeclaredField(obfName);
         } catch (Exception e) {
            try {
               field = cls1.getDeclaredField(deobfName);
            } catch (Exception e1) {
               continue;
            }
         }

         if (!field.isAccessible()) {
            field.setAccessible(true);
         }

         return field;
      }

      for (final Class Class1 : ClassUtils.getAllInterfaces(cls)) {
         try {
            field = Class1.getField(obfName);
         } catch (Exception e) {
            try {
               field = Class1.getField(deobfName);
            } catch (Exception e1) {
               continue;
            }
         }

         return field;
      }

      throw new RuntimeException("Error reflecting field: " + deobfName + "/" + obfName + " @" + cls.getSimpleName());
   }

   public static Object getFieldValue(final Object target, String obfName, String deobfName) {
      if (target == null)
         return null;

      Class cls = target.getClass();
      Field field = null;
      for (Class cls1 = cls; cls1 != null; cls1 = cls1.getSuperclass()) {
         try {
            field = cls1.getDeclaredField(obfName);
         } catch (Exception e) {
            try {
               field = cls1.getDeclaredField(deobfName);
            } catch (Exception e1) {
               continue;
            }
         }

         if (!field.isAccessible()) {
            field.setAccessible(true);
         }

         try {
            return field.get(target);
         } catch (Exception e) {
            throw new RuntimeException("Error getting reflected field value: " + deobfName + "/" + obfName + " @" + target.getClass().getSimpleName());
         }
      }

      for (final Class Class1 : ClassUtils.getAllInterfaces(cls)) {
         try {
            field = Class1.getField(obfName);
         } catch (Exception e) {
            try {
               field = Class1.getField(deobfName);
            } catch (Exception e1) {
               continue;
            }
         }

         try {
            return field.get(target);
         } catch (Exception e) {
            throw new RuntimeException("Error getting reflected field value: " + deobfName + "/" + obfName + " @" + target.getClass().getSimpleName());
         }
      }

      throw new RuntimeException("Error getting reflected field value: " + deobfName + "/" + obfName + " @" + target.getClass().getSimpleName());
   }

   public static void writeField(final Object target, final Object value, String obfName, String deobfName) {
      if (target == null)
         return;

      final Class cls = target.getClass();
      final Field field = getField(cls, obfName, deobfName);

      if (!field.isAccessible()) {
         field.setAccessible(true);
      }

      try {
         field.set(target, value);
      } catch (Exception e) {
         throw new RuntimeException("Error writing reflected field: " + deobfName + "/" + obfName + " @" + target.getClass().getSimpleName());
      }

   }

   public static Object invokeMethod(Object target, String obfName, String deobfName, Object... args) {
      Object o = null;
      try {
         o = MethodUtils.invokeMethod(target, obfName, args);
      } catch (Exception e) {
         try {
            o = MethodUtils.invokeMethod(target, deobfName, args);
         } catch (Exception e1) {
            throw new RuntimeException("Error reflecting method: " + deobfName + "/" + obfName + " @" + target.getClass().getSimpleName());
         }
      }

      return o;
   }
}
