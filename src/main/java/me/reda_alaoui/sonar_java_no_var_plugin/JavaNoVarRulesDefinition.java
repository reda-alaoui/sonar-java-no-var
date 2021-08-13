package me.reda_alaoui.sonar_java_no_var_plugin;

import java.util.Collections;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonarsource.analyzer.commons.RuleMetadataLoader;

/** @author Réda Housni Alaoui */
class JavaNoVarRulesDefinition implements RulesDefinition {

  public void define(Context context) {
    NewRepository repository =
        context.createRepository(JavaNoVarRepository.KEY, "java").setName("Java No Var Repository");

    new RuleMetadataLoader("me/reda_alaoui/sonar_java_no_var_plugin/rules/java")
        .addRulesByAnnotatedClass(repository, Collections.<Class>singletonList(NoVarRule.class));

    repository.done();
  }
}
