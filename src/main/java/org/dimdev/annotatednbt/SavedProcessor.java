package org.dimdev.annotatednbt;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.tools.Diagnostic;
import java.util.*;

@SupportedAnnotationTypes("org.dimdev.annotatednbt.Saved")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class SavedProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(Saved.class)) {
            TypeElement enclosingClass = (TypeElement) element.getEnclosingElement();
            if (enclosingClass.getAnnotationsByType(NBTSerializable.class).length == 0) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Field " + element.getSimpleName() + " is annotated @Saved but containg class " + enclosingClass.getQualifiedName() + " is not annotated @NBTSerializable");
            }
        }
        return true;
    }
}
